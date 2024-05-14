import LoginRobot from "../robots/amazon/authentication/login";
import NavBarRobot from "../robots/amazon/navBar";
import AccountDetails from "../robots/amazon/authentication/accountDetails";
import HomePageRobot from "../robots/amazon/homePage";

context("login test", () => {
  const authentication = new LoginRobot();
  const navBarRobot = new NavBarRobot();
  const account = new AccountDetails();
  const homePage = new HomePageRobot();

  describe("amazon login ", () => {
    before("visiting amazon", () => {
      homePage.startApp();
    });
    it("account login ", () => {
      authentication.login();
      navBarRobot.navigation();
      navBarRobot.primeFilter();
      account.myList();
    });
  });
});
