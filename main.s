.section .text
.global _start
_start:
pushq $1
pushq $2
pushq $3
pushq $4
pushq $5
popq %rbx
popq %rax
pushq %rbx
pushq %rax
pushq $7
pushq $8
pushq $9
popq %rbx
popq %rax
addq %rbx, %rax
pushq %rax
pushq $10
popq %rbx
popq %rax
mulq %rbx
pushq %rax
pushq $5
popq %rbx
popq %rax
subq %rbx, %rax
pushq %rax
popq %rsi
call print
pushq $6
popq %rbx
popq %rax
pushq %rbx
pushq %rax
pushq %rbx
pushq $7
popq %rbx
popq %rax
pushq %rbx
popq %rbx
popq %rax
mulq %rbx
pushq %rax
popq %rbx
popq %rax
subq %rbx, %rax
pushq %rax
pushq $8
popq %rbx
popq %rax
pushq %rax
pushq %rbx
pushq %rax
popq %rsi
call print
popq %rsi
call print
popq %rsi
call print
popq %rsi
call print
popq %rsi
call print
popq %rsi
call print
exit:

	mov $60,%rax
		xor %rdi, %rdi
	syscall