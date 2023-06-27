from selenium import webdriver
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.common.by import By

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://www.training-support.net/selenium/tables")
    print("The title of the page is: ", driver.title)
    rows = driver.find_elements(By.XPATH, "//table[contains(@class, 'sortable')]/tbody/tr")
    cols = driver.find_elements(By.XPATH,"//table[contains(@class, 'sortable')]/thead/tr/th")
    print("Number of rows present are: ", len(rows))
    print("Number of columns present are: ", len(cols))
    second_row_second_column_value = driver.find_element(By.XPATH, "//table[contains(@class, 'sortable')]/tbody/tr[2]/td[2]")
    print("The value at second reow and second value is: ", second_row_second_column_value.text)
    driver.find_element(By.XPATH,"//table[contains(@class, 'sortable')]/thead/tr/th").click()
    second_row_second_column_value_new = driver.find_element(By.XPATH,"//table[contains(@class, 'sortable')]/tbody/tr[2]/td[2]")
    print("The value at second reow and second value is: ", second_row_second_column_value_new.text)
    footer_values = driver.find_elements(By.XPATH,"//table[contains(@class, 'sortable')]/tfoot/tr/th")
    print("footer values are: ")
    for cell in footer_values:
        print(cell.text)
