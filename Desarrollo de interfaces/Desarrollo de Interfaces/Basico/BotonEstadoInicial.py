from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow): 

    
          
    def __init__(self): 
        super().__init__() 

        self.botonPulsado = True

        self.setWindowTitle("MiTitulo")

        boton = QPushButton("Pulsa")

        boton.setCheckable(True)

        boton.clicked.connect(self.botonActivado)

        boton.setChecked(self.botonPulsado)

        self.setCentralWidget(boton)

    def botonActivado(self,estado):
        self.botonPulsado=estado
        print(self.botonPulsado)

app = QApplication([])

window = MainWindow()

window.show()



app.exec() # Poner siempre si no la ventana se cierra instant