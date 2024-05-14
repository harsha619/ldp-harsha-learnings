import { Dependencies, RobotEyes, RobotHands } from "./../Robot";
import data from "../../../fixtures/example.json";

export default class LoginRobot {
  private loginRobotHands = new LoginRobotHands();
  private loginRobotEyes = new LoginRobotEyes();

  public login() {
    this.loginRobotEyes.assertLoginText();
    this.loginRobotHands.clickLogin();

    this.loginRobotEyes.assertEmail();
    this.loginRobotHands.enterEmail();

    this.loginRobotEyes.assertContinue();
    this.loginRobotHands.clickContinue();

    this.loginRobotEyes.assertPassword();
    this.loginRobotHands.enterPassword();

    this.loginRobotEyes.assertSignInSubmit;
    this.loginRobotHands.clickSignInSubmit();
  }
}
export class LoginDependency extends Dependencies {}
export class LoginRobotEyes extends RobotEyes {
  assertLoginText() {
    this.seesIdVisible("nav-link-accountList");
  }
  assertEmail() {
    this.seesDomVisibleWithCustomMatcher("name", "email");
  }
  assertPassword() {
    this.seesDomVisibleWithCustomMatcher("name", "password");
  }

  assertContinue() {
    this.seesIdVisible("continue");
  }
  assertSignInSubmit() {
    this.seesIdVisible("signInSubmit");
  }
}

export class LoginRobotHands extends RobotHands {
  clickLogin() {
    this.clickOnId("nav-link-accountList");
  }
  enterEmail() {
    this.typeTextonDom("name", "email", data.email);
  }
  clickContinue() {
    this.clickOnId("continue");
  }
  enterPassword() {
    this.typeTextonDom("name", "password", data.password);
  }
  clickSignInSubmit() {
    this.clickOnId("signInSubmit");
  }
}
