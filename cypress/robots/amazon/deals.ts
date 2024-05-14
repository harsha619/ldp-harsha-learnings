import { Dependencies, RobotEyes, RobotHands } from "./Robot";
import data from "../../fixtures/example.json";

export default class DealsRobot {
  private dealsRobotHands = new DealsRobotHands();
  private dealsRobotEyes = new DealsRobotEyes();

  public deals() {
    this.dealsRobotEyes.assertDeals();
    this.dealsRobotHands.clickDeals();
    this.dealsRobotEyes.assertDealsPage();
    this.dealsRobotEyes.assertDealsContainer();
    this.dealsRobotEyes.assertDealItems();
    this.dealsRobotHands.clickOnThirdItem();
  }
}

export class DealsRobotEyes extends RobotEyes {
  private dealsUrl = "/deals?ref_=nav_cs_gb";
  assertDeals() {
    this.seeTextByHref(this.dealsUrl, "Today's Deals");
  }
  assertDealsPage() {
    this.seesPathNameInUrl("/deals");
    this.seeTextByDataId("deals-header", "Today's Deals");
  }
  assertDealsContainer() {
    this.seeTestId("grid-deals-container");
  }
  assertDealItems() {
    this.seeTestIdByLength("deal-card", 2);
  }
}

export class DealsRobotHands extends RobotHands {
  private dealsUrl = "/deals?ref_=nav_cs_gb";
  clickDeals() {
    this.clickOnHref(this.dealsUrl);
  }
  clickOnThirdItem() {
    this.clickOnItemByTestIdAndLength("deal-card", 1);
  }
}
