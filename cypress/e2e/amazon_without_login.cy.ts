import { RobotEyes, RobotHands, Dependencies } from "../robots/amazon/Robot";
import DealsRobot from "../robots/amazon/deals";
import HomePageRobot from "../robots/amazon/homePage";
import ItemCardRobot from "../robots/amazon/itemCard";
import MobileRobot from "../robots/amazon/mobile";
import NavBarRobot from "../robots/amazon/navBar";

context("This is a end to end testing for adding items into cart flow", () => {
  const homePageRobot = new HomePageRobot();
  const dealsRobot = new DealsRobot();
  const itemCardRobot = new ItemCardRobot();
  const mobileRobot = new MobileRobot();
  const navBarRobot = new NavBarRobot();
  describe("Adding item into cart", () => {
    it("Should be able to add mobiles into cart", () => {
      homePageRobot.openApp();
      dealsRobot.getDeals();
      itemCardRobot.itemCard();
      itemCardRobot.addToCart();
      itemCardRobot.checkQuantityInShoppingCart();
      mobileRobot.searchMobiles();
      mobileRobot.printMobileDetails();
      navBarRobot.navigation();
      navBarRobot.filterCheckBox();
      navBarRobot.mainMenu();
    });
  });
});
