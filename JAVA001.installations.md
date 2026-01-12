# Download and install Java.

### **Step 1: Download Java**:

Link: [Download JDK - Java Deverlopment Kit (Oracle)](https://www.oracle.com/java/technologies/downloads/)

> Note:
>
> - Select the JDK that matchs your OS (Windows, macOS, Linux)
> - Recommended to install the **Long-Term Support (LTS) version** and using _x64 Installer_

### **Step 2: Install JDK**

> Open the installed file "**jdk-25_windows-x64_bin.exe**" and install.

All you need to do is simply click **Next**, ...

### **Step 3: Setup local Java enviroment**

3.1. Go to **C:\Program Files\Java\jdk-25\bin** can copy this directory path.  
3.2. Open search, type "View advanced system setting" and open.  
3.3. Click **Enviroment Variables..**, go to **System variables**.  
3.4. Click new, set:

```text
Variable name = JAVA_HOME
Variable value= <the copied path in 3.1>
```

then click **OK**.  
3.5. Select **PATH** and click **Edit**.  
3.6. Click **New**, _**paste the copied path to the input box**_, then click **OK**.  
3.7. Finally, just click **OK** > **Apply** > **OK**.

### **Step 4: Verify the installation**

Open `cmd` (Command promt) and run this command:

```bash
java --version
```

The result should belike:

```bash
java 21.0.8 2025-07-15 LTS
Java(TM) SE Runtime Environment (build 21.0.8+12-LTS-250)
Java HotSpot(TM) 64-Bit Server VM (build 21.0.8+12-LTS-250, mixed mode, sharing)
```

If no, the installation is failed.

---

### **To run any Java source file (`.java` files) using `cmd`**:

- First, compile this file:
  > `javac filename.java`
- Then, you can run the compiled file:
  > `java filename.java`
