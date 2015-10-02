'''
Created on Oct 2, 2015

@author: munirah
'''
#Write string to file
fw = open('munirah.txt', 'w')
fw.write('Nama\t:\tNoor Munirah bt Md Saad\nId\t:\t2014828976\nKursus\t:\tCS708\nUniversiti\t:\tUiTM Kampus Shah Alam\n')
fw.close()

#read the file in ASCII mode
frb = open('munirah.txt', 'rb')
txtB = frb.read()
#print to console
print(txtB)
frb.close()

#Write the file in reverse order (ascii)
with open ('munirah.txt', 'rb') as filein, open('munirah_Binary_Reverse.txt', 'wb') as fileout:
    fileout.writelines(reversed(filein.readlines()))