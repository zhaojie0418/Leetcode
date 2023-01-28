public class numberOfRounds1904 {
    public int numberOfRounds(String loginTime, String logoutTime) {
        int loginHour = Integer.parseInt(loginTime.substring(0, 2));
        int logoutHour = Integer.parseInt(logoutTime.substring(0, 2));
        int loginMin = Integer.parseInt(loginTime.substring(3, 5));
        int logoutMin = Integer.parseInt(logoutTime.substring(3, 5));
        int login = loginHour * 60 + loginMin;
        int logout = logoutHour * 60 + logoutMin;
        if (login > logout) {
            logout += 1440;
        }
        logout = logout / 15 * 15;
        return (logout-login)/15;
    }
}
