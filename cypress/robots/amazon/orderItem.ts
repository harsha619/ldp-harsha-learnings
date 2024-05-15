import { Dependencies, RobotEyes, RobotHands } from "./Robot";
import data from "../../fixtures/example.json";

export default class OrderItemRobot {
  private orderItemRobotHands = new OrderItemRobotHands();
  private orderItemRobotEyes = new OrderItemRobotEyes();
  private orderItemRobotDependency = new OrderItemDependency();

  public getItemDetails() {
    this.orderItemRobotEyes.assertItemTitleId();
    this.orderItemRobotDependency.printItemDetails();
  }

  public addItemToCart() {
    this.orderItemRobotEyes.assertAddToCartButton();
    this.orderItemRobotHands.clickOnCartButton();

    this.orderItemRobotDependency.waitForCart();
    this.orderItemRobotHands.clickOnCartButtonOnReview();
  }
  public checkItemQuantityInCart() {
    this.orderItemRobotDependency.printProductTitle();
    this.orderItemRobotEyes.assertMinimumValueIn();
  }
}

export class OrderItemDependency extends Dependencies {
  printItemDetails() {
    this.logTextById("productTitle");
  }
  printProductTitle() {
    this.logTextByClassName("a-truncate-cut");
  }
  waitForCart() {
    this.waitForDomContainText("attach-view-cart-button-form", 60000);
  }
}
export class OrderItemRobotEyes extends RobotEyes {
  assertItemTitleId() {
    this.seesIdVisible("productTitle");
  }

  assertDropDownById() {
    this.seeDropDownById("quantity");
  }
  assertAddToCartButton() {
    this.seesDomEnabled("#add-to-cart-button");
  }
  assertMinimumValueIn() {
    this.checkMinimumValueInDropDown("#quantity", 1);
  }
}

export class OrderItemRobotHands extends RobotHands {
  clickOnDropDown() {
    this.changeDropDown("quantity", 0);
  }
  clickOnCartButton() {
    this.clickOnDomByText("input[type='submit']", "Add to Cart");
  }
  clickOnCartButtonOnReview() {
    this.clickOnDomElement("#attach-view-cart-button-form");
  }
}
