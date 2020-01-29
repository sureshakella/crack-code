package fornow;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InMemoryRecentHistoryRecs {

    static class UserRec {
        Integer userId;
        Integer productId;
        UserRec(Integer _usrId, Integer _prodId) {
            this.userId = _usrId;
            this.productId = _prodId;
        }
    }

    static class Recommendations<T>{
        private Deque<T> recs = new LinkedList<>();

        void add(T rec) {
            recs.addFirst(rec);
        }

        Deque<T> fetch(Predicate filterCriteria) {
            return (Deque<T>) recs.stream().filter(filterCriteria).collect(Collectors.toCollection(LinkedList::new));
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Recommendations<UserRec> myHistory = new Recommendations();
        for(int i=0; i<10; i++) {
            int clicked = rand.nextInt(100000) + 200000;
            System.out.print(clicked + "==>");
            myHistory.add(new UserRec(1, clicked));
        }
        System.out.println();
        Predicate<UserRec> usrId1Filter = s -> s.userId.equals(1);
        myHistory.fetch(usrId1Filter).forEach(rec -> System.out.print(rec.productId + "==>"));
//        System.out.println("Recs for User 2");
//        Predicate<UserRec> usrId2Filter = s -> s.userId.equals(2);
//        myHistory.fetch(usrId2Filter).forEach(rec -> System.out.print(rec.productId + "==>"));
    }


}
