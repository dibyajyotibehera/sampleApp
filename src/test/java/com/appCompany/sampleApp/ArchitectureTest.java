package com.appCompany.sampleApp;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.http.ResponseEntity;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.appCompany.sampleApp", importOptions = ImportOption.DoNotIncludeTests.class)
class ArchitectureTest {

    private static final String CONTROLLER = "Controller";

    private static final String REPOSITORY = "Repository";

    private static final String SERVICE = "Service";

    private static final String CLIENT = "Client";

    @ArchTest
    static final ArchRule layer_dependencies_are_respected = layeredArchitecture().layer(CONTROLLER)
        .definedBy("..controller..").layer(SERVICE).definedBy("..service..").layer(REPOSITORY)
        .definedBy("..repository..").layer(CLIENT).definedBy("..client..").whereLayer(CONTROLLER)
        .mayNotBeAccessedByAnyLayer().whereLayer(SERVICE).mayOnlyBeAccessedByLayers(CONTROLLER)
        .whereLayer(REPOSITORY).mayOnlyBeAccessedByLayers(SERVICE).whereLayer(CLIENT)
        .mayOnlyBeAccessedByLayers(SERVICE);

    @ArchTest
    static final ArchRule methods_should_return_response_entity = methods().that().arePublic().and()
        .areDeclaredInClassesThat().resideInAPackage("..controller..").should()
        .haveRawReturnType(ResponseEntity.class)
        .because("Controller endpoints should return a ResponseEntity object");

}
