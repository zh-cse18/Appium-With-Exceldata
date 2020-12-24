import urllib.request

def dl_jpg(url,file_path,file_name):
    full_path = file_path + file_name + '.png'
    urllib.request.urlretrieve(url,full_path)

url = input('Enter img URl')
file_name = input('Write directory name :')

dl_jpg(url,'C:\\Users\\Zahid Hassan\\Desktop\\',file_name)



