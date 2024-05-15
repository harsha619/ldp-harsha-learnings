import LoginRobot from "../robots/amazon/authentication/login";
import NavBarRobot from "../robots/amazon/navigationBar";
import AccountDetails from "../robots/amazon/authentication/accountDetails";
import HomePageRobot from "../robots/amazon/homePage";

context(
  "This is a end to end testing for Amazon Login  and account details flow",
  () => {
    const authenticationRobot = new LoginRobot();
    const navBarRobot = new NavBarRobot();
    const accountRobot = new AccountDetails();
    const homePageRobot = new HomePageRobot();

    describe("checking the Amazon Login  and account details", () => {
      before("visiting amazon", () => {
        homePageRobot.openApp();
      });
      it("should check amazon login and account details ", () => {
        authenticationRobot.login();
        navBarRobot.navigateToMobileCategory();
        navBarRobot.primeFilter();
        accountRobot.getOrderPaymentList();
      });
    });
  }
);
