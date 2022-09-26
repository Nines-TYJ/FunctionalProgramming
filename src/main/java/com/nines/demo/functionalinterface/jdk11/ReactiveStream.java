package com.nines.demo.functionalinterface.jdk11;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @author tanyujie
 * @classname ReactiveStream
 * @description TODO
 * @date 2022/6/6 11:25
 * @since 1.0
 */
public class ReactiveStream extends SubmissionPublisher<String> implements Flow.Processor<Integer, String> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        // 保持订阅关系, 需要它来给发布者响应
        this.subscription = subscription;
        // 请求一个数据
        this.subscription.request(1);
    }

    @Override
    public void onNext(Integer item) {
        // 接收一个数据
        System.out.println("处理器接收到数据" + item);
        // 过滤掉大于0的，然后发布
        if (item < 0) {
            this.submit("转换后的数据" + Math.abs(item));
        }
        // 处理完调用request再请求一个数据
        this.subscription.request(1);
        // 或者达到目标调用cancel告诉发布者不再接收数据了
        // this.subscription.cancel();
    }

    @Override
    public void onError(Throwable throwable) {
        // 出现异常
        throwable.printStackTrace();
        // 告诉发布者, 后面不接受数据
        this.subscription.cancel();
    }

    @Override
    public void onComplete() {
        // 全部数据处理完
        System.out.println("处理器处理完成");
        // 关闭发布者
        this.close();
    }
}

class Demo{
    public static void main(String[] args) throws InterruptedException {
        // 定义发布者，发布数据类型是Integer, 使用JDK自带的SubmissionPublisher
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<Integer>();
        // 定义处理器, 对数据过滤并转换为String类型
        ReactiveStream processor = new ReactiveStream();
        // 发布者与处理器建立订阅关系
        publisher.subscribe(processor);
        // 定义订阅者, 消费String类型数据
        Flow.Subscriber<String> subscriber = new Flow.Subscriber<>() {

            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                // 保持订阅关系, 需要它来给发布者响应
                this.subscription = subscription;
                // 请求一个数据
                this.subscription.request(1);
            }

            @Override
            public void onNext(String item) {
                // 接收一个数据
                System.out.println("消费者接收到数据" + item);
                // 处理完调用request再请求一个数据
                this.subscription.request(1);
                // 或者达到目标调用cancel告诉发布者不再接收数据了
                // this.subscription.cancel();
            }

            @Override
            public void onError(Throwable throwable) {
                // 出现异常
                throwable.printStackTrace();
                // 告诉发布者, 后面不接受数据
                this.subscription.cancel();
            }

            @Override
            public void onComplete() {
                // 全部数据处理完
                System.out.println("消费者处理完成");
            }
        };
        // 处理者与订阅者建立订阅关系
        processor.subscribe(subscriber);
        // 生产数据并发布
        var data = 50;
        for (int i = 1; i <= 5; i++) {
            data = data - i * 20;
            publisher.submit(data);
        }
        // 结束后关闭发布者
        publisher.close();

        // 主线程延迟停止
        Thread.currentThread().join(1000);
    }
}
