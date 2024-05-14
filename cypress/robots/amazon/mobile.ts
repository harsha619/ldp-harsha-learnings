import { Dependencies, RobotEyes, RobotHands } from "./Robot";
import data from "../../fixtures/example.json";

export default class MobileRobot {
  private mobilesRobotHands = new MobileRobotHands();
  private mobilesRobotEyes = new MobileRobotEyes();
  private mobileDependency = new MobileDependency();

  public searchMobiles() {
    this.mobilesRobotEyes.assertSearchBar();
    this.mobilesRobotHands.searchForMobiles();
    this.mobilesRobotEyes.assertSearchIcon();
    this.mobilesRobotHands.clickOnSearch();
    this.mobilesRobotEyes.assertMobileSearchWord();

    this.mobilesRobotEyes.assertMobilesComponent();
    this.mobilesRobotHands.scrollDown();
  }
  public printMobileDetails() {
    this.mobileDependency.printLastMobileDetails();
  }
}
const type = "s-search-result";
export class MobileDependency extends Dependencies {
  printLastMobileDetails() {
    this.logLastCompTextByType(type, "a-text-normal");
  }
}
export class MobileRobotEyes extends RobotEyes {
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

export class MobileRobotHands extends RobotHands {
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
