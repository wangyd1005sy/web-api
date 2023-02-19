//package wang.xiaoluobo.web.api.utils;
//
//import org.springframework.security.core.context.SecurityContextHolder;
//import wang.xiaoluobo.web.api.enums.ServerResponseEnum;
//import wang.xiaoluobo.web.api.exception.ServiceException;
//import wang.xiaoluobo.web.api.model.MyUserDetails;
//
//public final class ContextUtils {
//
//    public static MyUserDetails getPrincipal() {
//        if (SecurityContextHolder.getContext().getAuthentication() == null) return null;
//        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (obj instanceof MyUserDetails) {
//            return (MyUserDetails) obj;
//        }
//        throw new ServiceException(ServerResponseEnum.NO_RIGHT);
//    }
//}
