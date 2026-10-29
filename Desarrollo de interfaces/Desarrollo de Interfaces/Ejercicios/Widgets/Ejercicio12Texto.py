from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget

class MainWindow(QMainWindow): # Asi se crea una clase

    
    
    def __init__(self): # Asi se crea una funcio 
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiTitulo")

        label = QLabel()
        input = QLineEdit()

        input.textChanged.connect(label.setText) # Asi python ya sabe que tiene que ponerlo en el label automaticamente
        layout = QVBoxLayout()
        
        layout.addWidget(input)
        layout.addWidget(label)


        contenedor = QWidget()
        contenedor.setLayout(layout)

        
    
        self.setCentralWidget(contenedor)

    
            
             
       
           
app = QApplication([])
window = MainWindow()
window.show()


app.exec() # Poner siempre si no la ventana se cierra instant