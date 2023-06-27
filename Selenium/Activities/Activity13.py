from selenium import webdriver
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService 
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.common.by import By

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://www.training-support.net/selenium/tables")
    print("The title of page is: ", driver.title)
    wait = WebDriverWait(driver,10)
    #Find the number of rows and columns in the table and print them.
    rows = driver.find_elements(By.XPATH,"//table[contains(@class, 'striped')]/tbody/tr")
    cols = driver.find_elements(By.XPATH,"//table[contains(@class, 'striped')]/tbody/tr[1]/td")
    print("Number of rows present: ", len(rows))
    print("Number of columns present are: ", len(cols))
#Find and print all the cell values in the third row of the table.
    third_row = driver.find_elements(By.XPATH,"//table[contains(@class, 'striped')]/tbody/tr[3]/td")
    print("cell values in third row are: ")
    for row in third_row:
        print("Cell value: ", row.text)
#Find and print the cell value at the second row second column.
    second_row_column_value = driver.find_element(By.XPATH,"//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]")
    print("Cell value at second row and second column: ", second_row_column_value.text)
