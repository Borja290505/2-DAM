from PyQt6.QtWidgets import QApplication, QComboBox, QDateEdit, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QMessageBox, QPushButton, QTextEdit, QVBoxLayout, QWidget# Se importa solo lo que necesitas
from PyQt6.QtCore import QDate, QSize, Qt

class MainWindow(QMainWindow):
    def __init__(self): 
        super().__init__() 
        self.setWindowTitle("EJERCICIO 1 REPASO") 

    #<===================================================>
        nombreHL = QHBoxLayout()

        self.nombre_label = QLabel("Nombre: ")
        self.nombre_lineEdit = QLineEdit()

        nombreHL.addWidget(self.nombre_label)
        nombreHL.addWidget(self.nombre_lineEdit)
    #<===================================================>
        apellidosHL = QHBoxLayout()

        self.apellidos_label = QLabel("Apellidos: ")
        self.apellidos_lineEdit = QLineEdit()
        
        apellidosHL.addWidget(self.apellidos_label)
        apellidosHL.addWidget(self.apellidos_lineEdit)
    #<===================================================>
        fechaHL = QHBoxLayout()
    
        self.fecha_label = QLabel("Fecha: ")
        self.fecha_dateEdit = QDateEdit()

        self.fecha_dateEdit.setCalendarPopup(True)
        self.fecha_dateEdit.setMinimumDate(QDate(2006,1,1))

        fechaHL.addWidget(self.fecha_label)
        fechaHL.addWidget(self.fecha_dateEdit)
    #<===================================================>
        departamentoHL = QHBoxLayout()
        
        self.departamento_label = QLabel("Departamento: ")
        self.departamento_comboBox = QComboBox()
        self.departamento_comboBox.addItems(["Contabilidad","Ventas","Reparto"])

        departamentoHL.addWidget(self.departamento_label)
        departamentoHL.addWidget(self.departamento_comboBox)
    #<===================================================>
        descripcionHL = QHBoxLayout()
                
        self.descripcion_label = QLabel("Descripcion: ")
        self.descripcion_editText = QTextEdit()

        descripcionHL.addWidget(self.descripcion_label)
        descripcionHL.addWidget(self.descripcion_editText)
    #<===================================================>
        botonesAbajo = QHBoxLayout()
    
        self.boton1 = QPushButton("Enviar")
        self.boton2 = QPushButton("Reset")

        self.boton1.pressed.connect(self.escribir)
        self.boton2.pressed.connect(self.reset)

        botonesAbajo.addWidget(self.boton1)
        botonesAbajo.addWidget(self.boton2)
    #<===================================================>
        layoutV = QVBoxLayout()
        layoutV.addLayout(nombreHL)
        layoutV.addLayout(apellidosHL)
        layoutV.addLayout(fechaHL)
        layoutV.addLayout(departamentoHL)
        layoutV.addLayout(descripcionHL)
        layoutV.addLayout(botonesAbajo)

        contenedor = QWidget()
        contenedor.setLayout(layoutV)
        self.setCentralWidget(contenedor)

    def escribir(self):
        if(self.nombre_lineEdit.text()!="" and self.apellidos_lineEdit.text()!=""):
            dlg = QMessageBox(self)
            dlg.setWindowTitle("Confirmacion")
            dlg.setText(f"Si eres {self.nombre_lineEdit.text()} { self.apellidos_lineEdit.text()} pulsa si")
            dlg.setStandardButtons(QMessageBox.StandardButton.Yes | QMessageBox.StandardButton.No)

            if dlg.exec() == QMessageBox.StandardButton.Yes:
                self.close()
            else:
                self.nombre_lineEdit.clear()
                self.apellidos_lineEdit.clear()
        else:
            dlg = QMessageBox(self)
            dlg.setWindowTitle("Error")
            dlg.setText(f"Se deben rellenar los campos nombre y apellidos")
            dlg.setStandardButtons(QMessageBox.StandardButton.Ok)
            dlg.exec()

    def reset(self):
        self.nombre_lineEdit.clear()
        self.apellidos_lineEdit.clear()
        self.descripcion_editText.clear()
        self.fecha_dateEdit.setDate(QDate(2006,1,1))
        self.departamento_comboBox.setCurrentIndex(0) 



app = QApplication([]) 

window = MainWindow() 

window.show() 

app.exec()