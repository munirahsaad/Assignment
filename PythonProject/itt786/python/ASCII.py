'''
Created on Oct 2, 2015

@author: munirah
'''
#Write string to file
fw = open('munirah.txt', 'w')
fw.write('Nama\t:\tNoor Munirah bt Md Saad\nId\t:\t2014828976\nKursus\t:\tCS708\nUniversiti\t:\tUiTM Kampus Shah Alam\n')
fw.close()

#read the file in ASCII mode
fra = open('munirah.txt', 'r')
txtA = fra.read()
#print to console
print(txtA)
fra.close()

#Write the file in reverse order (ascii)
with open ('munirah.txt') as filein, open('munirah_ASCII_Reverse.txt', 'w') as fileout:
    fileout.writelines(reversed(filein.readlines()))
