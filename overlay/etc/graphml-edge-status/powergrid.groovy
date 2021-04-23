import org.opennms.netmgt.model.OnmsSeverity;
import org.opennms.features.topology.plugins.topo.graphml.status.GraphMLEdgeStatus;

/*
Color/format of links:

- Solid thick green = Link is up -> solid thick line
- Link at 80% utilization -> solid thick yellow
- Link is in 'Build' status -> solid thin blue line
- Broken link -> thick dashed line
*/

thickGreen  = [ 'stroke' :  'green', 'stroke-width' :  '6' ];
thickYellow = [ 'stroke' : 'yellow', 'stroke-width' :  '6' ];
thinBlue    = [ 'stroke' :   'blue', 'stroke-width' :  '3' ];
thickDashed = [ 'stroke-dasharray' : '5,5', 'stroke-width' :  '6' ];

// Defaults
Map<String, String> style = thickDashed;

return new GraphMLEdgeStatus().severity(severity).style(style);
