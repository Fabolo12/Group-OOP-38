package module3.lecture12;

import java.util.HashSet;
import java.util.Set;

public class Observer {

    public static void main(String[] args) {
        //create subject
        MyTopic topic = new MyTopic();

        //create observers
        Observers obj1 = new MyTopicSubscriber("Obj1");
        Observers obj2 = new MyTopicSubscriber("Obj2");
        Observers obj3 = new MyTopicSubscriber("Obj3");

        MyTopic topic2 = new MyTopic();
        Observers obj4 = new MyTopicSubscriber("Obj4");

        obj1.setSubject(topic);
        obj2.setSubject(topic);
        obj3.setSubject(topic);

        obj3.setSubject(topic2);
        obj4.setSubject(topic2);

        //now send message to subject
        topic.notifyObservers("New Message");
        topic2.notifyObservers("New Message from Topic 2");
    }

    interface Subject {
        //methods to register and unregister observers
        void register(Observers obj);

        void unregister(Observers obj);

        //method to notify observers of change
        void notifyObservers(String message);
    }

    interface Observers {
        //method to update the observer, used by subject
        void update(String massage);

        //attach with subject to observe
        void setSubject(Subject sub);
    }

    static class MyTopic implements Subject {

        private final Set<Observers> observers;

        public MyTopic() {
            this.observers = new HashSet<>();
        }

        @Override
        public void register(Observers obj) {
            observers.add(obj);
        }

        @Override
        public void unregister(Observers obj) {
            observers.remove(obj);
        }

        @Override
        public void notifyObservers(final String message) {
            for (Observers obj : observers) {
                obj.update(message);
            }
        }
    }

    static class MyTopicSubscriber implements Observers {

        private final String name;

        public MyTopicSubscriber(String nm) {
            this.name = nm;
        }

        @Override
        public void update(final String message) {
            System.out.println(name + ":: Consuming message::" + message);
        }

        @Override
        public void setSubject(final Subject sub) {
            sub.register(this);
        }
    }
}
