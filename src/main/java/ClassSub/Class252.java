package ClassSub;

import net.minecraft.util.*;
import java.net.*;
import com.mojang.authlib.yggdrasil.*;
import com.mojang.authlib.*;
import cn.Hanabi.*;
import com.mojang.authlib.exceptions.*;

private class Class252 extends Thread
{
    private final String password;
    private final String username;
    final Class54 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class252(final Class54 this$0, final String username, final String password) {
        this.this$0 = this$0;
        super();
        this.username = username;
        this.password = password;
        Class54.access$0(this$0, EnumChatFormatting.GRAY + "Idle...");
    }
    
    private final void checkAndAddAlt(final String username, final String password) {
        final YggdrasilUserAuthentication yggdrasilUserAuthentication = (YggdrasilUserAuthentication)new YggdrasilAuthenticationService(Proxy.NO_PROXY, "").createUserAuthentication(Agent.MINECRAFT);
        yggdrasilUserAuthentication.setUsername(username);
        yggdrasilUserAuthentication.setPassword(password);
        try {
            yggdrasilUserAuthentication.logIn();
            Class91.registry.add(new Class98(username, password, yggdrasilUserAuthentication.getSelectedProfile().getName()));
            try {
                Hanabi.INSTANCE.altFileMgr.getFile(Class169.class).saveFile();
            }
            catch (Exception ex2) {}
            Class54.access$0(this.this$0, "Alt added. (" + username + ")");
        }
        catch (AuthenticationException ex) {
            Class54.access$0(this.this$0, EnumChatFormatting.RED + "Alt failed!");
            ex.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        if (this.password.equals("")) {
            Class91.registry.add(new Class98(this.username, ""));
            Class54.access$0(this.this$0, EnumChatFormatting.GREEN + "Alt added. (" + this.username + " - offline name)");
            return;
        }
        Class54.access$0(this.this$0, EnumChatFormatting.AQUA + "Trying alt...");
        this.checkAndAddAlt(this.username, this.password);
    }
}