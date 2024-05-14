import { BaseHands, BaseEyes, BaseDependencies } from "../BaseRobot";
import data from "../../fixtures/example.json";

export class Dependencies extends BaseDependencies {
  wait() {
    cy.wait(2000);
  }
  logTextById(id: string) {
    cy.get(`#${id}`)
      .invoke("text")
      .then((item) => {
        cy.log(item);
      });
  }
  logTextByClassName(className: string) {
    cy.get(`.${className}`)
      .invoke("text")
      .then((item) => {
        cy.log(item);
      });
  }
  logLastCompTextByType(type: string, className: string) {
    cy.get(`[data-component-type='${type}']`)
      .last()
      .find(`.${className}`)
      .invoke("text")
      .then((item) => {
        cy.log(item);
      });
  }
  waitForDomContainText(id: string, timer: number) {
    cy.get(`#${id}`, { timeout: timer }).should("be.visible");
    return this;
  }
}

export class RobotEyes extends BaseEyes {
  seeURL() {
    cy.url().should("eq", data.base_url);
    return this;
  }
  seeTitle(title: string) {
    cy.title().should("eq", title);
    return this;
  }
  seeTextByHref(url: string, text: string) {
    cy.get(`a[href='${url}']`).should("have.text", text);
    return this;
  }
  seeTextByDataId(dataId: string, text: string) {
    cy.get(`[data-id='${dataId}']`).contains(text).should("be.visible");
  }
  seeTestId(dataTestId: string) {
    cy.get(`[data-testid='${dataTestId}']`).should("be.visible");
  }
  seeTestIdByLength(dataTestId: string, length: number) {
    cy.get(`[data-testid='${dataTestId}']`).should(
      "have.length.greaterThan",
      length
    );
  }
  seeDropDownById(id: string) {
    cy.get(`[id='${id}']`).find(`[name='${id}']`).should("be.visible");
  }
  checkMinimumValueInDropDown(id: string, minimumValue: number) {
    cy.get(id).then(($select) => {
      const minValue = $select.find("option").eq(minimumValue).attr("value");
      cy.log("Minimum value: " + minValue);
      cy.get(id).should("have.value", minValue);
    });
  }
  seesTextContainsWithClass(domClass: string, text: string) {
    cy.get(`.${domClass}`).should("contain", text);
    return this;
  }
  checkComponentLengthByType(type: string) {
    cy.get(`[data-component-type='${type}']`).should(
      "have.length.greaterThan",
      1
    );
  }
  seeByDataCardIdentifier(id: string) {
    cy.get(`[data-card-identifier='${id}']`).click();
  }
}

export class RobotHands extends BaseHands {
  clickOnDataTestId(id: string) {
    cy.get(`[data-testid='${id}']`).click();
    return this;
  }
  clickOnHref(url: string) {
    cy.get(`a[href='${url}']`).click();
    return this;
  }
  clickOnItemByTestIdAndLength(dataTestId: string, index: number) {
    cy.get(`[data-testid='${dataTestId}']`).eq(index).click();
  }
  changeDropDown(id: string, value: number) {
    cy.get(`[id='${id}']`).select(value);
  }
  clickOnDomByText(dom: string, text: string) {
    cy.get(dom).contains(text).click();
  }
  scrollToLastWithComponentType(type: string) {
    cy.get(`[data-component-type='${type}']`).last().scrollIntoView();
    return this;
  }
  clickOnDomContainText(dom: string, text: string) {
    cy.get(dom).contains(text).click();
  }
  selectDropDownByIdAndIndex(id: string, index: number) {
    cy.get(`#${id}`).select(`${index}`, { force: true });
  }

  clickOnClass(className: string) {
    cy.get(`.${className}`).click();
    return this;
  }

  typeTextonName(name: string, text: string) {
    cy.get(`[name="${name}"]`).type(text, { force: true });
    return this;
  }

  waitForCityName() {
    cy.get("#address-ui-widgets-enterAddressCity").should(($input) => {
      expect($input.val().length).to.be.gt(1);
    });
    return this;
  }

  clickOnDataCardIdentifier(id: string) {
    cy.get(`[data-card-identifier='${id}']`).click();
  }
  checkById(id: string) {
    cy.get(`#${id}`).check({
      force: true,
    });
  }
}
