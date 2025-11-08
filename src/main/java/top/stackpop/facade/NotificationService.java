package top.stackpop.facade;

/**
 * 通知子系统。
 */
public class NotificationService {

    public void notifySuccess(String userId, String message) {
        System.out.println("通知服务：发送成功通知给 " + userId + " 内容：" + message);
    }

    public void notifyFailure(String userId, String message) {
        System.out.println("通知服务：发送失败通知给 " + userId + " 内容：" + message);
    }
}

