package behavioral.observer;

/**
 * 主题，被订阅者，被观察者
 *
 * @author liangkuai
 * @date 2018/12/4
 */
public interface Subject {

    void register(Observer o);

    void remove(Observer o);

    void notifyAllObservers();
}
