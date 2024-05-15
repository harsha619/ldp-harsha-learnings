import { RobotEyes, RobotHands, Dependencies } from "../robots/amazon/Robot";
import DealsRobot from "../robots/amazon/deals";
import HomePageRobot from "../robots/amazon/homePage";
import OrderItemRobot from "../robots/amazon/orderItem";
import ProductRobot from "../robots/amazon/product";
import NavigationBarRobot from "../robots/amazon/navigationBar";

context("This is a end to end testing for adding items into cart flow", () => {
  const homePageRobot = new HomePageRobot();
  const dealsRobot = new DealsRobot();
  const orderItemRobot = new OrderItemRobot();
  const productRobot = new ProductRobot();
  const navigationBarRobot = new NavigationBarRobot();
  describe("Adding item into cart", () => {
    it("Should be able to add mobiles into cart", () => {
      homePageRobot.openApp();
      dealsRobot.getDeals();
      orderItemRobot.getItemDetails();
      orderItemRobot.addItemToCart();
      orderItemRobot.checkItemQuantityInCart();
      productRobot.searchMobiles();
      productRobot.printMobileDetails();
      navigationBarRobot.navigateToMobileCategory();
      navigationBarRobot.filterCheckBox();
      navigationBarRobot.mainMenu();
    });
  });
});
