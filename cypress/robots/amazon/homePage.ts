import { Dependencies, RobotEyes, RobotHands } from "./Robot";
import data from "../../fixtures/example.json";

export default class HomePageRobot {
  private homePageHands = new HomePageHands();
  private homePageRobotEyes = new HomePageEyes();
  private homePageDependency = new Dependencies();

  public openApp() {
    this.homePageDependency.accessUrl(data.base_url);
    this.homePageRobotEyes.seeURL();
    this.homePageRobotEyes.seeTitle(data.amazon_title);
  }
}

export class HomePageEyes extends RobotEyes {}

export class HomePageHands extends RobotHands {
  clickProfile() {
    this.clickOnDataTestId("profile-button");
  }
}
