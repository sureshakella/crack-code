package fornow.arrays;

import java.util.*;

//App Perf Profiler
//
//        Input:
//
//        Func    Timestamp    Begin/End
//        foo      10            Begin
//        bar      20            Begin
//        bar      50            End
//        foo      100           End
//
//        foo b
//        bar b
//        car b
//        car e
//        bar e
//        foo e
//
//        Output:
//        Func        Exclusive Time
//        foo          20-10 + 100-50 = 60
//        bar          50-20 = 30

// Loosely inspired by https://www.careercup.com/question?id=5646979695640576

public class AppProfiler {

    public static void main(String[] args) {
        List<Log> logs = Arrays.asList(
                new Log("foo", 10, "begin"),
                new Log("bar", 20, "begin"),
                new Log("bar", 50, "end"),
                new Log("car", 70, "begin"),
                new Log("car", 90, "end"),
                new Log("foo", 100, "end"));
        betterCodeProfiler(logs);
        System.out.println("second one");
        List<Log> logs2 = Arrays.asList(
                new Log("foo", 10, "begin"),
                new Log("bar", 20, "begin"),
                new Log("car", 50, "begin"),
                new Log("car", 70, "end"),
                new Log("bar", 90, "end"),
                new Log("foo", 100, "end"));
        betterCodeProfiler(logs2);
        System.out.println("third one");
        List<Log> logs3 = Arrays.asList(
                new Log("foo", 10, "begin"),
                new Log("bar", 20, "begin"),
                new Log("car", 50, "begin"),
                new Log("dog", 60, "begin"),
                new Log("dog", 65, "end"),
                new Log("car", 70, "end"),
                new Log("bar", 90, "end"),
                new Log("foo", 100, "end"));
        betterCodeProfiler(logs3);
        System.out.println("fourth one");
        List<Log> logs4 = Arrays.asList(
                new Log("foo", 10, "begin"),
                new Log("bar", 20, "begin"),
                new Log("bar", 50, "end"),
                new Log("foo", 100, "end"));
        betterCodeProfiler(logs4);
    }

    private static void codeProfiler(List<Log> logs) {
        Stack<Log> logStack = new Stack<>();
        //Technically I don't need stack here just another variable would suffice as I always pop n push
        Stack<Integer> eTimeStack = new Stack<>();
        String prevFunc = null;
        for(Log itrLog : logs) {
            if (itrLog.action.equals("begin")) {
                logStack.push(itrLog);
            }
            else {
                Log top = logStack.pop();
                if(itrLog.name.equals(top.name)) {
                    if (prevFunc.equals(top.name)) {
                        int eTime = itrLog.timestamp - top.timestamp;
                        if (eTimeStack.isEmpty()) {
                            eTimeStack.push(eTime);
                        }
                        else {
                            eTimeStack.push(eTime + eTimeStack.pop());
                        }
                        System.out.println(top.name + " " + eTime);
                    }
                    else {
                        int topEtime = eTimeStack.pop();
                        int eTime = itrLog.timestamp - top.timestamp - topEtime;
                        System.out.println(top.name + " " + eTime);
                        eTimeStack.push(eTime + topEtime);
                    }
                }
            }
            prevFunc = itrLog.name;
        }
    }

    private static void betterCodeProfiler(List<Log> logs) {
        Stack<Log> logStack = new Stack<>();
        int totalElapsed = 0;
        String prevFunc = null;
        for(Log currLog : logs) {
            if (currLog.action.equals("begin")) {
                logStack.push(currLog);
            }
            else {
                Log top = logStack.pop();
                if(currLog.name.equals(top.name)) {
                    int eTime;
                    if (prevFunc.equals(top.name)) {    //No sub-function chain
                         eTime = currLog.timestamp - top.timestamp;
                    }
                    else {  //sub-functions is cascading more like tree chain
                        eTime = currLog.timestamp - top.timestamp - totalElapsed;
                    }
                    System.out.println(top.name + " " + eTime);
                    totalElapsed+=eTime;
                }
                //else - This mean the call stack is not appropriate. Input action seq is not balanced
            }
            prevFunc = currLog.name;
        }
    }

    static class Log {
        String name;
        int timestamp;
        String action;
        Log(String name, int timestamp,String action) {
            this.name = name;
            this.timestamp = timestamp;
            this.action = action;
        }
    }
}
