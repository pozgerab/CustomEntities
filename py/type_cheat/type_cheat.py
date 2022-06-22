from selenium import webdriver

url = 'https://youtube.com'
driver = webdriver.Chrome(executable_path='C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe')  # or Chrome
driver.get('https://www.youtube.com/watch?v=TuXg3Id01ZM')
elem = driver.find_element_by_id('search')
print(elem.text)
