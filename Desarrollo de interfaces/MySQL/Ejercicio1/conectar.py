from operator import le

import mysql.connector
from Ejercicio1 import Ui_MainWindow

from PyQt6.QtWidgets import QMainWindow, QApplication

class MainWindow(QMainWindow,Ui_MainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Conectar BD")
        self.setupUi(self)

        self.lista_datos = []
        self.posicion = 0

        self.pushButton_2.clicked.connect(self.anterior)
        self.pushButton_3.clicked.connect(self.siguiente)
        self.pushButton.clicked.connect(self.primero)
        self.pushButton_4.clicked.connect(self.ultimo)

        try:
            self.con = mysql.connector.connect(
                host = "localhost",
                port=3306,
                user="root",
                password="1234",
                database="capitales"
            )
            self.cargarDatos()
        except mysql.connector.Error as error:
            print(error)

    def cargarDatos(self):
        cursor=self.con.cursor()
        sql = "SELECT * FROM capitales"
        cursor.execute(sql)
        self.lista_datos = cursor.fetchall()
        if (len(self.lista_datos) > 0):
            self.mostrar()

    def mostrar(self):
        fila = self.lista_datos[self.posicion]
        self.lineEdit.setText(str(fila[0]))
        self.lineEdit_2.setText(str(fila[1]))
        self.lineEdit_3.setText(str(fila[2]))

    def siguiente(self):
        fila1 = self.lista_datos[self.posicion+1]
        self.lineEdit.setText(str(fila1[0]))
        self.lineEdit_2.setText(str(fila1[1]))
        self.lineEdit_3.setText(str(fila1[2]))
        self.posicion+=1;

    def anterior(self):
        fila2 = self.lista_datos[self.posicion-1]
        self.lineEdit.setText(str(fila2[0]))
        self.lineEdit_2.setText(str(fila2[1]))
        self.lineEdit_3.setText(str(fila2[2]))
        self.posicion-=1;

    def primero(self):
        if (len(self.lista_datos)>0):
            self.posicion=0
            self.mostrar()

    def ultimo(self):
        if (len(self.lista_datos)>0):
            self.posicion=len(self.lista_datos)-1
            self.mostrar()

app = QApplication([])
ventana = MainWindow()
ventana.show()
app.exec()