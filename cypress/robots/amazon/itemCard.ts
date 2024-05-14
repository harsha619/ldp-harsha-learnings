import { Dependencies, RobotEyes, RobotHands } from "./Robot";
import data from "../../fixtures/example.json";

export default class ItemCardRobot {
  private itemCartRobotHands = new ItemCartRobotHands();
  private itemCartRobotEyes = new ItemCartRobotEyes();
  private itemCartRobotDependency = new ItemCardDependency();

  public itemCard() {
    this.itemCartRobotEyes.assertItemTitleId();
    this.itemCartRobotDependency.printItemDetails();
  }

  public addToCart() {
    this.itemCartRobotEyes.assertAddToCartButton();
    this.itemCartRobotHands.clickOnCartButton();

    this.itemCartRobotDependency.waitForCart();
    this.itemCartRobotHands.clickOnCartButtonOnReview();
  }
  public checkQuantityInShoppingCart() {
    this.itemCartRobotDependency.printProductTitle();
    this.itemCartRobotEyes.assertMinimumValueIn();
  }
}

export class ItemCardDependency extends Dependencies {
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
export class ItemCartRobotEyes extends RobotEyes {
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

export class ItemCartRobotHands extends RobotHands {
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
