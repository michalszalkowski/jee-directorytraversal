import requests

print('----------- Directory Traversal -----------')


def do(url_file):
    def get_status(path):
        try:
            return requests.head(path).status_code
        except requests.ConnectionError:
            return None

    with open(url_file) as url_file:
        for url in url_file:
            try:
                status = get_status(url.rstrip())
            except Exception as e:
                status = 0

            if status == 200:
                print(str(status) + " [yep we have something] " + url.rstrip())
            elif status == 404:
                print(str(status) + " [it seems that resource does`t exist] " + url.rstrip())
            else:
                print(str(status) + " [some crazy shit, check this] " + url.rstrip())


print("----------------- Test controller 1 -----------------")
do("urls_1.txt")
print("-----------------Test controller 2 -----------------")
do("urls_2.txt")
