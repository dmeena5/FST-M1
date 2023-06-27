from selenium import webdriver
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.select import Select
from selenium.webdriver.common.by import By

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://www.training-support.net/selenium/selects")
    print("The title of the page is: ", driver.title)
    #On the Single Select:
    singleSelect = driver.find_element(By.ID, "single-select")
    dropdown = Select(singleSelect) 
    #Select the second option using the visible text.
    dropdown.select_by_visible_text("Option 2")
    print("The second option is: ", dropdown.first_selected_option.text)
    #Select the third option using the index.
    dropdown.select_by_index(3)
    print("The Third option is: ", dropdown.first_selected_option.text)
    #Select the fourth option using the value.
    dropdown.select_by_value("4")
    print("The Fourth option is: ", dropdown.first_selected_option.text)
    #Get all the options and print them to the console.
    select_options = dropdown.options
    for option in select_options:
        print("Option: ", option.text)