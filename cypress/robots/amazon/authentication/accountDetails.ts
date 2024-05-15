import { Dependencies, RobotEyes, RobotHands } from "../Robot";
import data from "../../../fixtures/example.json";

export default class AccountDetails {
  private accountDetailsRobotHands = new AccountDetailsRobotHands();
  private accountDetailsRobotEyes = new AccountDetailsRobotEyes();

  public getOrderPaymentList() {
    this.accountDetailsRobotEyes.assertOrders();
    this.accountDetailsRobotHands.clickOnOrders();

    this.accountDetailsRobotEyes.assertFilter();
    this.accountDetailsRobotHands.selectLastYear();

    this.accountDetailsRobotEyes.assertAccount();
    this.accountDetailsRobotHands.clickOnMyAccount();
    this.accountDetailsRobotHands.clickOnAddressesAnd1Click();
    this.accountDetailsRobotHands.clickOnFirstDesktopAddressTile();

    this.accountDetailsRobotHands.enterAddressDetails();
    this.accountDetailsRobotHands.clickOnMyAccount();

    this.accountDetailsRobotEyes.assertPaymentOptions();
    this.accountDetailsRobotEyes.assertPaymentOptionsPage();
  }
}

export class AccountDetailsRobotEyes extends RobotEyes {
  assertOrders() {
    this.seesIdVisible("nav-orders");
  }
  assertFilter() {
    this.seesIdVisible("time-filter");
  }
  assertAccount() {
    this.seesIdVisible("nav-link-accountList");
  }
  assertPaymentOptions() {
    this.seeByDataCardIdentifier("PaymentOptions");
  }
  assertPaymentOptionsPage() {
    this.seesIdVisible("walletTitleRow");
  }
}

export class AccountDetailsRobotHands extends RobotHands {
  clickOnOrders() {
    this.clickOnId("nav-orders");
  }
  selectLastYear() {
    this.selectDropDownByIdAndIndex("time-filter", 2023);
  }
  clickOnMyAccount() {
    this.clickOnId("nav-link-accountList");
  }
  clickOnAddressesAnd1Click() {
    this.clickOnDataCardIdentifier("AddressesAnd1Click");
  }
  clickOnFirstDesktopAddressTile() {
    this.clickOnClass("first-desktop-address-tile");
  }
  enterAddressDetails() {
    this.typeTextonName("address-ui-widgets-enterAddressFullName", data.name);
    this.typeTextonName(
      "address-ui-widgets-enterAddressPhoneNumber",
      data.phone_no
    );
    this.typeTextonName(
      "address-ui-widgets-enterAddressPostalCode",
      data.pincode
    );
    this.waitForCityName();
    this.typeTextonName("address-ui-widgets-enterAddressLine1", data.address);
    this.clickOnId("address-ui-widgets-form-submit-button");
  }
  clickOnPaymentOptions() {
    this.clickOnDataCardIdentifier("PaymentOptions");
  }
}
