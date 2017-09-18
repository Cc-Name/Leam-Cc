package cc.shake.com.mydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logger.w("%s %s", "logger", "第一个123");
//        Logger.e("MMBB");
//
//
//        Map<Object, Object> map = new HashMap<>();
//        map.put("key","1");
//        map.put("key1","1111");
//        Logger.w(map.toString());


//        //创建一个观察
//        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
//
//                observableEmitter.onNext(1);
//                observableEmitter.onNext(2);
//                observableEmitter.onNext(3);
//                observableEmitter.onComplete();
//
//
//            }
//        });
//        //观察者
//        Observer<Integer> observer =     new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable disposable) {
//                Logger.w("subscribe");
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                Logger.w("value"+integer);
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                Logger.w("error");
//            }
//
//            @Override
//            public void onComplete() {
//                Logger.w("complete");
//            }
//        };
        //订阅
//        observable.subscribe(observer);
//   }


        //同线程
//   Observable.create(new ObservableOnSubscribe<Integer>() {
//       @Override
//       public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
//           observableEmitter.onNext(1);
//           observableEmitter.onNext(2);
//           observableEmitter.onNext(3);
//
//           observableEmitter.onComplete();
//          // observableEmitter.onNext(3);
//           Logger.w("value3");
//
//       }
//
//       }
//   ).subscribe(new Observer<Integer>() {
//       private  Disposable mDisposable;
//       private   int    i = 0;
//
//       @Override
//       public void onSubscribe(Disposable disposable) {
//           Logger.w("subscribe");
//           mDisposable = disposable;
//       }
//
//       @Override
//       public void onNext(Integer integer) {
//           Logger.w("值是"+integer);
//
//           i++;
////           if(i==2){
////               mDisposable.dispose();
////               Logger.w("值是"+mDisposable.isDisposed());
////
////           }
//
//       }
//
//       @Override
//       public void onError(Throwable throwable) {
//           Logger.w("error");
//       }
//
//       @Override
//       public void onComplete() {
//
//           Logger.w("complete");
//       }
//   });
//
//    }

        //非同线程

//
//        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
//                Logger.w("emit :1");
//                observableEmitter.onNext(1);
//                Logger.w("Observable thread is : " + Thread.currentThread().getName());
//            }
//        });
//
//        Consumer<Integer> consumer = new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                Logger.w("值" + integer  );
//                Logger.w("onNext: " + Thread.currentThread().getName());
//            }
//        };
//      observable
//              .subscribeOn(Schedulers.newThread())
//              .subscribeOn(Schedulers.io())
//              .observeOn(AndroidSchedulers.mainThread())
//              .doOnNext(new Consumer<Integer>() {
//                  @Override
//                  public void accept(Integer integer) throws Exception {
//                      Logger.w("After observeOn(mainThread), current thread is: " + Thread.currentThread().getName());
//                  }
//              })
//              .observeOn(Schedulers.io())
//              .doOnNext(new Consumer<Integer>() {
//                  @Override
//                  public void accept(Integer integer) throws Exception {
//                      Logger.w("After observeOn(io), current thread is: " + Thread.currentThread().getName());
//
//                  }
//              })
//              .subscribe(consumer);

            // map  操作符  有序的
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
//                observableEmitter.onNext(1);
//                observableEmitter.onNext(2);
//                observableEmitter.onNext(3);
//            }
//        }).map(new Function<Integer, String>() {
//            @Override
//            public String apply(Integer integer) throws Exception {
//                return "This  is result" + integer;
//            }
//        }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Logger.w("" + s);
//            }
//        });
        
        //flatMap 操作符 无序的
//
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
//                observableEmitter.onNext(1);
//                observableEmitter.onNext(2);
//                observableEmitter.onNext(3);
//
//            }
//        }).flatMap(new Function<Integer, ObservableSource<String>>() {
//            @Override
//            public ObservableSource<String> apply(Integer integer) throws Exception {
//                 final List<String> list =  new ArrayList<>();
//                 for (int i = 0;i<3;i++){
//                     list.add("我是值"+integer);
//                 }
//
//                return  Observable.fromIterable(list).delay(10, TimeUnit.MILLISECONDS);
//            }
//        }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Logger.w("" + s);
//            }
//        });
//



        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                observableEmitter.onNext(1);
                observableEmitter.onNext(2);
                observableEmitter.onNext(3);

            }
        }).concatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                final List<String> list =  new ArrayList<>();
                for (int i = 0;i<3;i++){
                    list.add("我是值"+integer);
                }

                return  Observable.fromIterable(list).delay(10, TimeUnit.MILLISECONDS);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Logger.w("" + s);
            }
        });


    }


}