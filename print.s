.section .rodata
fmt:
   .asciz "%d\n"
eol:
   .asciz "\n"

.section .text
.globl print
print:
 push %rbp
 mov %rsp, %rbp
 mov $fmt, %rdi
 xor %rax, %rax
 xor %rdx, %rdx
 call printf
 mov %rbp, %rsp
 pop %rbp
 ret
