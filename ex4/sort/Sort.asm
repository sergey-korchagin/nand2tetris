// File name: Sort.asm
// Sorts R0 ..... R15 in descending order (4,51,6,12 ===>  51,12,6,4)
// (R0, R1, R2.... refer to RAM[0], RAM[1], and RAM[2]...., respectively.)

// Put your code here.

@100
D=A
@R0
M=D
@103
D=A
@R1
M=D
@102
D=A
@R2
M=D
@104
D=A
@R3
M=D
@104
D=A
@R4
M=D
@9
D=A
@R5
M=D
@93
D=A
@R6
M=D
@12
D=A
@R7
M=D
@16
D=A
@R8
M=D
@456
D=A
@R9
M=D
@1
D=A
@R10
M=D
@0
D=A
@R11
M=D
@911
D=A
@R12
M=D
@33
D=A
@R13
M=D
@89
D=A
@R14
M=D
@500
D=A
@R15
M=D
@R0
D=A
@temp
M=D
@temp2
@15
D=A
@count
M=D
(loop)
@temp
D=M
A=D
D=M
@count
D=M
@count2
M=D
@temp
D=M
@temp2
M=D
	(loop2)
	@temp2
	M=M+1
	//sort
		//var = r[temp]
		@temp
		A=M
		D=M
		@var
		M=D
		//var2 = r[temp2]
		@temp2
		A=M
		D=M
		@var2
		M=D
		//var1=var1-var2
		@var2
		D=M // D=var2
		@var
		M=M-D //var1=var1-var2
		D=M
		@noswap
		D;JGT
		//swap code
		//r[temp2] = r[temp]
		@temp
		A=M
		D=M
		@temp2
		A=M
		M=D
		//r[temp] = var2
		@var2
		D=M
		@temp
		A=M
		M=D
	(noswap)
	//end sort	
	@count2
	M=M-1
	D=M
	@loop2
	D;JGT
@temp
M=M+1
@count
M=M-1
D=M
@loop
D;JGT
@32767
0;JMP