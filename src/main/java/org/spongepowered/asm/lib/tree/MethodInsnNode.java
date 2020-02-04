package org.spongepowered.asm.lib.tree;

import org.spongepowered.asm.lib.*;
import java.util.*;

public final class MethodInsnNode extends AbstractInsnNode
{
    public String owner;
    public String name;
    public String desc;
    public boolean itf;
    
    private MethodInsnNode(final int n, final String s, final String s2, final String s3) {
        this(n, s, s2, s3, n == 185);
    }
    
    public MethodInsnNode(final int n, final String owner, final String name, final String desc, final boolean itf) {
        super(n);
        this.owner = owner;
        this.name = name;
        this.desc = desc;
        this.itf = itf;
    }
    
    public final void setOpcode(final int opcode) {
        this.opcode = opcode;
    }
    
    public final int getType() {
        return 5;
    }
    
    public final void accept(final MethodVisitor methodVisitor) {
        methodVisitor.visitMethodInsn(this.opcode, this.owner, this.name, this.desc, this.itf);
        this.acceptAnnotations(methodVisitor);
    }
    
    public final AbstractInsnNode clone(final Map<LabelNode, LabelNode> map) {
        return new MethodInsnNode(this.opcode, this.owner, this.name, this.desc, this.itf);
    }
}