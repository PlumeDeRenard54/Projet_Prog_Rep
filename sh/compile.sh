
run(){
    if [[ $1 == "Compute" ]]; then
        java -cp out/ LancerRaytracer simplerer.txt;
    elif [[ $1 == "Compile" ]]; then
        javac src/*/*.java  -d out
        echo "Compiled!";
    elif [[ $1 == "help" ]]; then
        echo -e "Help : \n  Noeud [host] [nbrDeNoeud]\n  Compute\n  Server\n  Client"
    elif [[ $1 == "Noeud" ]]; then

        # Récuperation des données en arguments
        nodenumber=1;
        host="localhost";

        if [[ -n $2 ]]; then
            host=$2 ; 
        fi

        if [[ -n $3 ]]; then
            nodenumber=$3;
        fi

        # Execution
        for ((i=0 ; i<${nodenumber} ; i++)); do
            java -cp out/ src.Noeud.MainNoeud ${host} & 
            echo "Noeud ${i} lancé" 
        done

    elif [[ $1 == "Server" ]]; then
        java -cp out/ src.Server.MainServeur &
    elif [[ $1 == "Client" ]]; then
        java -cp out/ src.Client.MainClient 500 500;
    fi
}

run Compile
run $1 $2 $3