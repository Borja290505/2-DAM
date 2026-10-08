from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView

class MainWindow(QMainWindow): # Asi se crea una clase

    
    
    def __init__(self): # Asi se crea una funcio 
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiAplicacion")

        self.texto = QLineEdit()
        self.texto.setMaxLength(100) # Para poner un limite de caracteres
        self.texto.setPlaceholderText("Escribe tu nombre...") # PlaceHolder de toda la vida
        self.texto.textChanged.connect(self.textoCambiado) # Mandar a hacer una funcion al escribir un caracter
        self.texto.returnPressed.connect(self.introPulsado) # Mandar a hacer una funcion al pulsar intro (NO MANDA ARGUMENTOS SOLO DISPARA FUNCION)
        self.setCentralWidget(self.texto)


    def textoCambiado(self, s):
        print(s) 

    def introPulsado(self):
        print("Intro Pulsado") 
        print(self.texto.text())


    
            
             
       
           
app = QApplication([])
window = MainWindow()
window.show()


app.exec() # Poner siempre si no la ventana se cierra instant1