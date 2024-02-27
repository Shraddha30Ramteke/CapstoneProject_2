from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time

def test_web_application():
    # Launch the browser
    driver = webdriver.Chrome()  # Replace with the appropriate WebDriver for your browser

    # 1. Navigate to the URL
    url = "http://webdriveruniversity.com/index.html"
    driver.get(url)

    # 2. Click on Dropdown-Checkboxes-RadioButtons link
    link = driver.find_element_by_link_text("Dropdown-Checkboxes-RadioButtons")
    link.click()

    # 3. Verify new tab and switch to it
    time.sleep(1)  # Allow some time for the new tab to open (You may need to adjust this)
    driver.switch_to.window(driver.window_handles[1])

    # 4. Select values from Drop Menu and verify
    drop_menu = driver.find_element_by_id("dropdowm-menu-1")
    drop_menu.click()
    value_to_select = "option3"
    driver.find_element_by_xpath(f"//option[text()='{value_to_select}']").click()
    assert drop_menu.get_attribute("value") == value_to_select

    # 5. Select Multiple Checkboxes and verify count
    checkboxes = driver.find_elements_by_xpath("//input[@type='checkbox']")
    for checkbox in checkboxes[:2]:
        checkbox.click()
    checked_checkboxes = driver.find_elements_by_xpath("//input[@type='checkbox'][@checked='checked']")
    assert len(checked_checkboxes) == 2
    assert len(checkboxes) - len(checked_checkboxes) == 1

    # 6. Select a radio button and verify count
    radio_button = driver.find_element_by_xpath("//input[@type='radio']")
    radio_button.click()
    checked_radio_buttons = driver.find_elements_by_xpath("//input[@type='radio'][@checked='checked']")
    assert len(checked_radio_buttons) == 1
    assert len(driver.find_elements_by_xpath("//input[@type='radio'][not(@checked)]")) == 2

    # Close the browser
    driver.quit()

# Run the test function
if __name__ == "__main__":
    test_web_application()
