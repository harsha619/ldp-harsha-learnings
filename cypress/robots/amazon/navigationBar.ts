import { Dependencies, RobotEyes, RobotHands } from "./Robot";
import data from "../../fixtures/example.json";

export default class NavigationBarRobot {
  private navBarRobotHands = new NavBarRobotHands();
  private navBarRobotEyes = new NavBarRobotEyes();

  public navigateToMobileCategory() {
    this.navBarRobotEyes.assertNavBar();
    this.navBarRobotHands.clickOnNavBar();

    this.navBarRobotEyes.assertMobileCategory();
    this.navBarRobotHands.clickOnMobileCategory();
    this.navBarRobotEyes.assertAllMobilePhones();
    this.navBarRobotHands.clickAllMobilePhones();
  }
  public filterCheckBox() {
    this.navBarRobotEyes.assertBrandCheckBox();
    this.navBarRobotHands.clickBrandCheckBox();
  }
  public primeFilter() {
    this.navBarRobotEyes.assertPrimeCheckBox();
    this.navBarRobotHands.clickPrimeCheckBox();
  }
  public mainMenu() {
    this.navBarRobotEyes.assertMainMenu();
    this.navBarRobotHands.clickOnMainMenu();
  }
}
export class NavBarDependency extends Dependencies {}
export class NavBarRobotEyes extends RobotEyes {
  assertNavBar() {
    this.seesIdVisible("nav-hamburger-menu");
  }
  assertMobileCategory() {
    this.seesDomContainText("a", "Mobiles, Computers");
  }
  assertAllMobilePhones() {
    this.seesDomContainText("a", "All Mobile Phones");
  }
  assertBrandCheckBox() {
    this.seesIdVisible("apb-browse-refinements-checkbox_5");
  }
  assertPrimeCheckBox() {
    this.seesIdVisible("apb-browse-refinements-checkbox_1");
  }
  assertMainMenu() {
    this.seesIdVisible("nav-logo-sprites");
  }
}

export class NavBarRobotHands extends RobotHands {
  clickOnNavBar() {
    this.clickOnId("nav-hamburger-menu");
  }
  clickOnMobileCategory() {
    this.clickOnDomContainText("a", "Mobiles, Computers");
  }
  clickAllMobilePhones() {
    this.clickOnDomContainText("a", "All Mobile Phones");
  }
  clickPrimeCheckBox() {
    this.checkById("apb-browse-refinements-checkbox_1");
  }
  clickBrandCheckBox() {
    this.checkById("apb-browse-refinements-checkbox_4");
  }
  clickOnMainMenu() {
    this.clickOnId("nav-logo-sprites");
  }
}
