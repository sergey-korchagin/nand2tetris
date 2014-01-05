// File name: Chess.asm

// Runs an infinite loop that listens to the keyboard input. 
// When a key is pressed (any key), the program draws chess board on the screen,
// i.e. writes "black" in every pixel that its coordinates sum is even
//Examples for black pixels: (0,0) (2,0) (1,1) (20,12) (13,5)....
//When no key is pressed, the screen should be cleared.

// Put your code here.

(init)
@SCREEN //init screen //16384
D=A  
@screenPointer  //pointer to place on screen(register) that need to draw 
M=D
@256 //row
D=A
@scCount
M=D


(pressed)
@KBD
D=M
@draw
D;JNE
@clear
0;JMP



(draw)


	
	
@screenPointer
M=M+1
M=M+1
@screenPointer
A=M
M=-1

@scCount
M=M-1
D=M
@draw
D;JGE

@screenPointer
M=M+1
@256
D=A


	
@scCount
M=D
@draw
0;JMP
 
 
(clear)
D=A  
@screenPointer  //pointer to place on screen(register) that need to draw 
M=D

	@screenPointer  
	A=M
	M=0
	@screenPointer 
	M=M+1
	
	@screenPointer 
	D=M
	@KBD
	D=A-D
	@pressed
	D;JLE
	
	@pressed
	0;JMP
	
	@clear
	0;JMP
	
	
	
 