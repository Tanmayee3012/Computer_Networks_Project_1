import threading
import socket

# server=input("Which connection do you want to use ?? \n Enter 1 for TCP \n Enter 2 for UDP \n")
# if(server==1)
# {
#     # TCP function in another file
# }
# else if(server==2)
# {
#     # UDP function in another file
# }



nickname = input('Choose a nickname: ')
client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect(('127.0.0.1', 2022))
#python multiclient.py

def client_receive():
    while True:
        try:
            message = client.recv(1024).decode('utf-8')
            if message == "nickname?":
                client.send(nickname.encode('utf-8'))
            else:
                print(message)
        except:
            print('Disconnected!')
            client.close()
            break


def client_send():
    message =input()
    while message.lower()!='bye':
        client.send(f'{nickname}: {message}'.encode('utf-8'))
        message =input()
    client.close()

receive_thread = threading.Thread(target=client_receive)
receive_thread.start()

send_thread = threading.Thread(target=client_send)
send_thread.start()