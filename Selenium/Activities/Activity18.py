from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.remote.webdriver import By
from selenium.webdriver.support.select import Select

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:
    driver.get("https://www.training-support.net/selenium/selects")
    print("Page title is: ", driver.title)

    multiselect_list = driver.find_element(By.ID, "multi-select")
    multiselect = Select(multiselect_list)

    multiselect.select_by_visible_text("Javascript")
    for x in range(4, 6):
        multiselect.select_by_index(x)
    multiselect.select_by_value("node")
    for option in multiselect.all_selected_options:
        print("Options selected are: ", option.text)

    multiselect.deselect_by_index(7)
    for option in multiselect.all_selected_options:
        print("Options selected are: ", option.text)