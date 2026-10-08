from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget
from PyQt6.QtGui import QPixmap

class MainWindow(QMainWindow): # Asi se crea una clase

    
    
    def __init__(self): # Asi se crea una funcio 
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiAplicacion")

        label = QLabel()
        label.setPixmap(QPixmap("Clase2/interfaces/img/remon1.jpg")) # Copiar ruta relativa y cambiar contrabarras por barras
        label.setScaledContents(True) # Para escalar la imagen al zoom
    
        self.setCentralWidget(label)

    
            
           
app = QApplication([])
window = MainWindow()
window.show()


app.exec() # Poner siempre si no la ventana se cierra instant