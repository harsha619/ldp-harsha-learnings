import { Dependencies, RobotEyes, RobotHands } from "./Robot";
import data from "../../fixtures/example.json";

export default class ProductRobot {
  private productRobotHands = new ProductRobotHands();
  private productRobotEyes = new ProductRobotEyes();
  private productDependency = new ProductDependency();

  public searchMobiles() {
    this.productRobotEyes.assertSearchBar();
    this.productRobotHands.searchForMobiles();
    this.productRobotEyes.assertSearchIcon();
    this.productRobotHands.clickOnSearch();
    this.productRobotEyes.assertMobileSearchWord();

    this.productRobotEyes.assertMobilesComponent();
    this.productRobotHands.scrollDown();
  }
  public printMobileDetails() {
    this.productDependency.printLastMobileDetails();
  }
}
const type = "s-search-result";
export class ProductDependency extends Dependencies {
  printLastMobileDetails() {
    this.logLastCompTextByType(type, "a-text-normal");
  }
}
export class ProductRobotEyes extends RobotEyes {
  assertSearchBar() {
    this.seesIdVisible("twotabsearchtextbox");
  }
  assertSearchIcon() {
    this.seesIdVisible("nav-search-submit-button");
  }
  assertMobileSearchWord() {
    this.seesTextContainsWithClass("s-desktop-toolbar", "mobiles");
  }
  assertMobilesComponent() {
    this.checkComponentLengthByType("s-search-result");
  }
}

export class ProductRobotHands extends RobotHands {
  searchForMobiles() {
    this.typeTextonId("twotabsearchtextbox", "mobiles");
  }
  clickOnSearch() {
    this.clickOnId("nav-search-submit-button");
  }
  scrollDown() {
    this.scrollToLastWithComponentType("s-search-result");
  }
}
