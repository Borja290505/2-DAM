from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow): # Creación de una clase
    
    cont = 0
    
    def __init__(self): # Creación de una función
        super().__init__() # LLamo al constructor del padre
        
        self.setWindowTitle("Mi aplicación")
        
        self.boton = QPushButton("Pulsa")
        
        self.boton.setCheckable(True) 
        self.boton.clicked.connect(self.botonActivado)
        self.boton.setChecked(True)
        
        self.setFixedSize(QSize(200,200)) 
        
        self.setCentralWidget(self.boton) 

    def botonActivado(self,checked):
        print(self.boton.isChecked())
                 
app = QApplication([])
window = MainWindow()
window.show()
app.exec()