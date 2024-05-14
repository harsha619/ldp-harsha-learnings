import { RobotEyes, RobotHands, Dependencies } from "../robots/amazon/Robot";
import DealsRobot from "../robots/amazon/deals";
import HomePageRobot from "../robots/amazon/homePage";
import ItemCardRobot from "../robots/amazon/itemCard";
import MobileRobot from "../robots/amazon/mobile";
import NavBarRobot from "../robots/amazon/navBar";

context("Search Test", () => {
  const homePage = new HomePageRobot();
  const dealsRobot = new DealsRobot();
  const itemCardRobot = new ItemCardRobot();
  const mobileRobot = new MobileRobot();
  const navBarRobot = new NavBarRobot();
  describe("Search the required information", () => {
    it("navigate to wikipedia page", () => {
      homePage.startApp();
      dealsRobot.deals();
      itemCardRobot.itemCard();
      itemCardRobot.addToCart();
      itemCardRobot.checkQuantityInShoppingCart();
      mobileRobot.searchMobiles();
      mobileRobot.printMobileDetails();
      navBarRobot.navigation();
      navBarRobot.filterCheckBox();
    });
  });
});
