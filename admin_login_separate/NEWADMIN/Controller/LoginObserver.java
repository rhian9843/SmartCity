// LoginObserver.java
package Controller;

public interface LoginObserver {
    void updateLoginState(boolean isLoggedIn, boolean isAdminLoggedIn);
}