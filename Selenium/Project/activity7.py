#Reading additional information
#Goal: Reading a popup that contains additional information about the account/lead.

from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.remote.webdriver import By
from selenium.webdriver.support import expected_conditions as EC

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Initialize wait object
    wait = WebDriverWait(driver, 10)

    # Navigate to the URL
    driver.get("https://alchemy.hguy.co/crm/")
    print("Home Page Title is: " + driver.title)
    driver.find_element(By.ID, "user_name").send_keys("admin")
    driver.find_element(By.ID,"username_password").send_keys("pa$$w0rd")
    driver.find_element(By.XPATH,"//*[@id=\"bigbutton\"]").click()
    navigationMenu = driver.find_element(By.ID,"toolbar").get_attribute("id")
    print("The user is on the home page with the Navigation Menu")
    #Reading additional information
    #Goal: Reading a popup that contains additional information about the account/lead.
    #sales selection
    wait.until(EC.visibility_of_element_located((By.XPATH,"//*[@id=\"grouptab_0\"]")))
    driver.find_element(By.XPATH,"//*[@id=\"grouptab_0\"]").click()
    #Leads selection
    wait.until(EC.visibility_of_element_located((By.XPATH, "//*[@id=\"moduleTab_9_Leads\"]")))
    driver.find_element(By.XPATH,"//*[@id=\"moduleTab_9_Leads\"]").click()
    #Additional Information icon selection
    wait.until(EC.visibility_of_element_located((By.XPATH,"//*[@id=\"adspan_1bf01e91-1f26-5249-ed14-63294367a7e5\"]/span")))
    driver.find_element(By.XPATH,"//*[@id=\"adspan_1bf01e91-1f26-5249-ed14-63294367a7e5\"]/span").click()
    wait.until(EC.visibility_of_element_located((By.XPATH,"//*[@id=\"ui-id-6\"]/div")))
    additional_details = driver.find_element(By.XPATH,"//*[@id=\"ui-id-6\"]/div")
    print("The header of the additional info popup is: " + additional_details.text)
    wait.until(EC.visibility_of_element_located((By.XPATH,"//*[@id=\"ui-id-5\"]/span")))
    PhoneNumber = driver.find_element(By.XPATH,"//*[@id=\"ui-id-5\"]/span")
    print("Mobile number of the lead is: " + PhoneNumber.text)